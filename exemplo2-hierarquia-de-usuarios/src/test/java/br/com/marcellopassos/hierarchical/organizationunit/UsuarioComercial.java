package br.com.marcellopassos.hierarchical.organizationunit;

import java.util.Objects;

import br.com.marcellopassos.hierarchical.IElement;

public class UsuarioComercial implements IElement<UsuarioComercialPK> {

    private  UsuarioComercialPK pk;

    private  String nome;

    private  UsuarioComercial gerente;

    public UsuarioComercial(String id, String nome) {
        this.pk = new UsuarioComercialPK(id);
        this.nome = nome;
        this.gerente = null;
    }

    public UsuarioComercial(String id, String nome, UsuarioComercial gerente) {
    	this.pk = new UsuarioComercialPK(id);
        this.nome = nome;
        this.gerente = gerente;
    }

    @Override
    public UsuarioComercialPK getPk() {
        return pk;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public UsuarioComercialPK getParentPk() {
        return gerente!=null ? gerente.getPk() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioComercial that = (UsuarioComercial) o;
        return Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, nome, gerente.getPk());
    }
}
