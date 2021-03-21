package br.com.marcellopassos.hierarchical.organizationunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrganizationUnitGenerator {

    public Collection<UsuarioComercial> generate() {
        List<UsuarioComercial> u = new ArrayList<>();
        u.add(new  UsuarioComercial(1L, "Renato", null));
        u.add(new  UsuarioComercial(2L, "Guto", 1L));
        u.add(new  UsuarioComercial(3L, "Hailton", 1L));
        u.add(new  UsuarioComercial(4L, "Vitor", 1L));
        u.add(new  UsuarioComercial(5L, "Marcos", 4L));
        u.add(new  UsuarioComercial(6L, "Caio", 4L));
        u.add(new  UsuarioComercial(7L, "Daniel", 4L));
        u.add(new  UsuarioComercial(9L, "Augusto", 2L));
        u.add(new  UsuarioComercial(10L, "Rafa", 7L));
        //this.generateRoots(elements);
        //this.generateChildren(elements);
        return u;
    }

    public UsuarioComercial getRandomElement(Collection<UsuarioComercial> elements) {
        final int parentIndex = (int) (Math.random() * elements.size());
        return elements.stream()
                .skip(parentIndex)
                .findFirst()
                .orElse(null);
    }

    private void generateRoots(List<UsuarioComercial> elements) {
        for (long i = 0; i < this.getRandomNumber(10); i++) {
            elements.add(new UsuarioComercial(i, String.valueOf(i)));
        }
    }

    private void generateChildren(List<UsuarioComercial> elements) {
        for (long i = elements.size(); i < this.getRandomNumber(1000); i++) {
            UsuarioComercial parent = this.getRandomElement(elements);
            elements.add(new UsuarioComercial(i, parent.getNome() + "." + (i), parent.getId()));
        }
    }

    private UsuarioComercial getRandomElement(List<UsuarioComercial> elements) {
        int parentIndex = (int) (Math.random() * elements.size());
        return elements.get(parentIndex);
    }

    private long getRandomNumber(int max) {
        long numberOfRoots = 0;
        do {
            numberOfRoots = Math.round(Math.random() * max);
        } while (numberOfRoots == 0);
        return numberOfRoots;
    }
}
