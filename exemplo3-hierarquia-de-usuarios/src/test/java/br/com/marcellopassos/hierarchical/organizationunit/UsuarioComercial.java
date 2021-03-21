package br.com.marcellopassos.hierarchical.organizationunit;

import br.com.marcellopassos.hierarchical.IElement;

import java.util.Objects;

public class UsuarioComercial implements IElement<Long> {

    private final Long id;

    private final String nome;

    private final Long gerenteId;

    public UsuarioComercial(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.gerenteId = null;
    }

    public UsuarioComercial(Long id, String nome, Long gerenteId) {
        this.id = id;
        this.nome = nome;
        this.gerenteId = gerenteId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Long getParentId() {
        return gerenteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioComercial that = (UsuarioComercial) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(gerenteId, that.gerenteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, gerenteId);
    }
}
