package managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;

import utils.MD5;
import concurso.basicas.Questao;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@SessionScoped
@ManagedBean
public class QuestaoBean {

	private Part anexo;

	public Part getAnexo() {
		return this.anexo;
	}

	public void setAnexo(Part anx) {
		this.anexo = anx;
	}

	public boolean hasAnexoImage () {
		return this.questao.getImagemAnexo() != null;
	}
	
	private Questao questao = new Questao();
	private IFachada fachada = Fachada.getInstancia();

	public Questao getQuestao() {
		return this.questao;
	}

	public List<Questao> getQuestoes() {
		return fachada.consultarTodasQuestoes();
	}

	public String salvar() {
		if (this.getAnexo() != null) {
			this.questao.setImagemAnexo(this.processUpload(this.getAnexo()));
		}

		if (questao.getId() == null || questao.getId() == 0) {
			questao.setId(null);
			fachada.inserir(questao);
		} else {
			fachada.alterar(questao);
		}
		return "index.xhtml?faces-redirect=true";
	}

	public String editar(Questao obj) {
		this.questao = obj;
		return "form.xhtml";
	}

	public String excluir(Questao obj) {
		try {
			fachada.remover(obj);
			return "questoes/index.xhtml?faces-redirect=true";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("Nao pode remover a questao "
							+ obj.getId(), e.getMessage()));
			return null;
		}
	}

	// Upload
	
	private String processUpload(Part anx) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String filename = new MD5(anx.getName()).getHash() + "." + this.getFileExt(anx);
		
		String filepath = context.getRealPath("/resources/upload/" + filename);
		File result = new File(filepath);
		
		System.out.println(filepath);
		
        try {
            byte[] buffer = new byte[8048];
            int bulk;
        	
        	FileOutputStream fileOutputStream = new FileOutputStream(result);
            InputStream anxData = anx.getInputStream();
            bulk = anxData.read(buffer);
            
            while (bulk >= 0) {
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
                bulk = anxData.read(buffer);
            }

            fileOutputStream.close();
            anxData.close();

            return filename;
        } catch (IOException e) {
            FacesMessage error = new FacesMessage("N‹o foi poss’vel realizar o uplaod da imagem.");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }

        return null;
	}
	
	public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part) value;

		if (!"image/jpeg".equals(file.getContentType()) && !"image/png".equals(file.getContentType())) {
			msgs.add(new FacesMessage("Aceitos apenas arquivos JPG e PNG"));
		}

		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
	
	private String getFileExt (Part file) {	
		return ("image/jpeg".equals(file.getContentType())) ? "jpg" : "png";
 	}
}
