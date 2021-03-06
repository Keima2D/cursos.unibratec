package managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name="uploadFilesBean")
@SessionScoped
public class UploadFilesBean {
   
    //Primitives
    private static final int BUFFER_SIZE = 6124;    
        
    /** Creates a new instance of UploadBean */
    public UploadFilesBean() {
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        ExternalContext extContext =  FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath("//WEB-INF//images//" + event.getFile().getFileName()));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = event.getFile().getInputstream();

            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg = 
                        new FacesMessage("File Description", "file name: " +
                        event.getFile().getFileName() + "file size: " + 
                        event.getFile().getSize() / 1024 +"content type: " + 
                        event.getFile().getContentType() + 
                        "The file was uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }       
    }    
}