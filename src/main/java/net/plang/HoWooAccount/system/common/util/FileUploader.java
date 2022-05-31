package net.plang.HoWooAccount.system.common.util;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.PlatformData;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Component
public class FileUploader {

    public static void uploadFile(PlatformData reqData, String filePackage) {
        String filePath = "C:\\dev\\http\\htdocs\\img\\";

        DataSet dataset = reqData.getDataSet("ds_img");
        FileOutputStream out = null;
        String fileName = dataset.getString(0, "EMP_FILE_NAME");
        filePath = filePath + filePackage + "\\";
        try {
            if (fileName != null) {
                out = new FileOutputStream(filePath + fileName);
                byte[] file = dataset.getBlob(0, "IMG_FILE_DATA"); // 이미지 파일을 가져온다.
                BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
                bufferedOut.write(file);
                bufferedOut.flush();
                bufferedOut.close();
                out.close();
                bufferedOut = null;
                out = null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
