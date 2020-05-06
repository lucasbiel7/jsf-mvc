package br.com.unibh.controller;

import br.com.unibh.model.Converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIInput;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

@ManagedBean(name = "converterController")
public class ConverterController {

    private Converter converter = new Converter();
    private UIInput numeroCampo;
    private UIPanel painelResultado;

    public Converter getConverter() {
        return converter;
    }

    public UIInput getNumeroCampo() {
        return numeroCampo;
    }

    public void setNumeroCampo(UIInput numeroCampo) {
        this.numeroCampo = numeroCampo;
    }

    public UIPanel getPainelResultado() {
        return painelResultado;
    }

    public void setPainelResultado(UIPanel painelResultado) {
        this.painelResultado = painelResultado;
    }

    public void toBinary() {
        handleError(() -> {
            converter.toBinary();
            painelResultado.setRendered(true);
            showMessageInfo("O número decimal foi convertido para binário");
        });
    }

    private void handleError(Runnable runnable){
        try{
            runnable.run();
        }catch (Exception e){
            showMessageError(e.getMessage());
        }
    }

    private void showMessage(String msg, FacesMessage.Severity severity) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage(severity,
                        msg,
                        null));
        facesContext.getPartialViewContext().getRenderIds().add("form:msg");
    }
    private void showMessageInfo(String msg) {
        showMessage(msg,SEVERITY_INFO);
    }

    private void showMessageError(String msg) {
        showMessage(msg,SEVERITY_ERROR);
    }

    public void toHex() {
        handleError(() -> {
            converter.toHex();
            painelResultado.setRendered(true);
            showMessageInfo("O número decimal foi convertido para Hexadecimal");
        });
    }

    public void toOctal() {
        handleError(() -> {
            converter.toOctal();
            painelResultado.setRendered(true);
            showMessageInfo("O número decimal foi convertido para Octal");
        });
    }

    public void limpar() {
        handleError(()->{
            converter.clear();
            painelResultado.setRendered(false);
            showMessageInfo("Resultados limpos");
        });
    }
}
