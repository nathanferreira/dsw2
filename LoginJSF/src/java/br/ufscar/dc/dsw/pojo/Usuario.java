package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
 
    @Id
    private String email;
    private String password;
    private boolean ativo;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Cliente> clientes;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Locadora> locadoras;
    
    @ManyToMany
    private List<Papel> papel;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Usuario))
		return false;
	Usuario other = (Usuario) obj;
	return other.email.equals(this.email);
    }
    
    @Override
    public String toString() {
        return email;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Papel> getPapel() {
        return papel;
    }

    public void setPapel(List<Papel> papel) {
        this.papel = papel;
    }

}
