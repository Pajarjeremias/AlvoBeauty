package projekti.demo.domain;
import jakarta.validation.constraints.*;
public class IlmoittautumisLomake {

    @NotEmpty
    private String username = "";

    @NotEmpty
    private String salasana = "";

    @NotEmpty
    private String salasanaTark = "";

    @NotEmpty
    private String rooli = "USER";


    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public String getSalasanaTark() {
        return salasanaTark;
    }

    public void setSalasanaTark(String salasanaTark) {
        this.salasanaTark = salasanaTark;
    }

    public String getRooli() {
        return rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }
    

   

    
}
