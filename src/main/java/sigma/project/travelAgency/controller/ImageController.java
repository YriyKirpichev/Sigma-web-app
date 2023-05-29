package sigma.project.travelAgency.controller;

import com.amazonaws.util.IOUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sigma.project.travelAgency.service.impl.TourServiceImpl;
import sigma.project.travelAgency.util.files.S3Service;

import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@Controller
@AllArgsConstructor
public class ImageController {

    private final S3Service s3Service;

    private final TourServiceImpl tourService;


    @SneakyThrows
    @GetMapping("/image/fire")
    public void showFireImage(Model model, HttpServletResponse response) {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = s3Service.getImage("fire.png").getObjectContent();
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }

    @SneakyThrows
    @GetMapping("/image/tour/{id}")
    public void showTourImages(Model model, HttpServletResponse response, @PathVariable Long id) {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        String fileName = tourService.getTourById(id).getImage();
        if(tourService.getTourById(id).getImage() != null)  {
            if (s3Service.getAmazonS3().doesObjectExist(s3Service.getBucketName(), fileName)) {
                InputStream inputStream = s3Service.getImage(fileName).getObjectContent();
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
            }
        }
    }

    @PostMapping(value = "/image/tour/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String setTourImage(Model model, HttpServletResponse response, @PathVariable Long id, @RequestParam("file") MultipartFile file, @ModelAttribute("index") Integer index) {
        String fileName = id + ":" + tourService.getTourById(id).getTitle();
        s3Service.uploadImage(fileName, file);

        return "create-tour";
    }

    @GetMapping("/image/tour/{id}/delete")
    public String deleteTourImage(Model model, @PathVariable Long id){
        String fileName = id + ":" + tourService.getTourById(id).getTitle();
        s3Service.deleteImage(fileName);
        return "create-tour";
    }
}
