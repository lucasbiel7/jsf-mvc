package br.com.unibh.model;

/**
 * @author Lucas Gabriel
 */
public class Converter {
    int numero;
    String result;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void toBinary(){
        this.result = Integer.toBinaryString(numero);
    }
    public void toHex(){
        this.result = Integer.toHexString(numero);
    }
    public void toOctal(){
        this.result = Integer.toOctalString(numero);
    }

    public void clear() {
        numero = 0;
        this.result = null;
    }
}
