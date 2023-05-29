package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileWrapper {

    private List<MultipartFile> fileList = new ArrayList<>();

    public void addFile(MultipartFile file){
        this.fileList.add(file);
    }

}
