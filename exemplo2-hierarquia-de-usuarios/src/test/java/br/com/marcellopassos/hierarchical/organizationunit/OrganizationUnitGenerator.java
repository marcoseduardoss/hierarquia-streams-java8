package br.com.marcellopassos.hierarchical.organizationunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrganizationUnitGenerator {

    public Collection<UsuarioComercial> generate() {
        
        UsuarioComercial renato = new  UsuarioComercial("fec216ab-973f-45e0-b1fd-8fbb0a1c6a10", "Renato", null);
		UsuarioComercial guto = new  UsuarioComercial("4148d6c9-2180-4e9d-ac8c-626b40ecd446", "Guto", renato);
		UsuarioComercial hailton = new  UsuarioComercial("a126fab8-036b-49d4-81e3-f0b4660b7faa", "Hailton", renato);
		UsuarioComercial vitor = new  UsuarioComercial("d5696ac6-0415-4fbd-af51-12e144fa7132", "Vitor", renato);
		UsuarioComercial marcos = new  UsuarioComercial("e244b44c-1d27-40d2-abbf-39d9b2f7abc1", "Marcos", vitor);
		UsuarioComercial caio = new  UsuarioComercial("9ad9602b-9fa2-4448-80ec-266c59969665", "Caio", vitor);
		UsuarioComercial daniel = new  UsuarioComercial("ae711cb0-e2dc-4bb2-ac19-9f3bc57299e4", "Daniel", vitor);
		UsuarioComercial augusto = new  UsuarioComercial("1fddcd88-ef0b-4cf5-939f-211d4f4fa1f1", "Augusto", guto);
		UsuarioComercial rafa = new  UsuarioComercial("b9566751-46a0-4fc1-9bde-f0da7bda3959", "Rafa", daniel);
		
		List<UsuarioComercial> list = new ArrayList<>();
        list.add(renato);
		list.add(guto);
		list.add(hailton);
		list.add(vitor);
		list.add(marcos);
		list.add(caio);
        list.add(daniel);
        list.add(augusto);
        list.add(rafa);
        return list;
    }

    public UsuarioComercial getRandomElement(Collection<UsuarioComercial> elements) {
        final int parentIndex = (int) (Math.random() * elements.size());
        return elements.stream()
                .skip(parentIndex)
                .findFirst()
                .orElse(null);
    }
//
//    private void generateRoots(List<UsuarioComercial> elements) {
//        for (long i = 0; i < this.getRandomNumber(10); i++) {
//            elements.add(new UsuarioComercial(i, String.valueOf(i)));
//        }
//    }
//
//    private void generateChildren(List<UsuarioComercial> elements) {
//        for (long i = elements.size(); i < this.getRandomNumber(1000); i++) {
//            UsuarioComercial parent = this.getRandomElement(elements);
//            elements.add(new UsuarioComercial(i, parent.getNome() + "." + (i), parent.getId()));
//        }
//    }

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
