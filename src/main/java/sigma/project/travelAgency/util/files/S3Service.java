package sigma.project.travelAgency.util.files;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@Getter
public class S3Service {

    private final String bucketName;
    private final AmazonS3 amazonS3;

    public S3Service(Map<String, String> conf) {
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(conf.get("endpoint"), conf.get("region")))
                .build();
        this.bucketName = conf.get("bucket");
    }

    @SneakyThrows
    public void uploadImage(String key, MultipartFile file) {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            amazonS3.putObject(bucketName, key, file.getInputStream(), metadata);
    }

    public S3Object getImage(String key) {

        return amazonS3.getObject(bucketName, key);

    }

    public void deleteImage(String key){
        amazonS3.deleteObject(bucketName,key);
    }
}
