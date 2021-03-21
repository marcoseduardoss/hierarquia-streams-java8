package br.com.marcellopassos.hierarchical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import br.com.marcellopassos.hierarchical.organizationunit.OrganizationUnitGenerator;
import br.com.marcellopassos.hierarchical.organizationunit.UsuarioComercial;
import br.com.marcellopassos.hierarchical.organizationunit.UsuarioComercialPK;

public class IHierarchyServiceTest {

	private IHierarchyService<UsuarioComercial, UsuarioComercialPK> service;
	private OrganizationUnitGenerator organizationUnitGenerator;

	@BeforeEach
	void setUp() {
		this.organizationUnitGenerator = new OrganizationUnitGenerator();
		this.service = new HierarchyService<>(organizationUnitGenerator.generate());
	}

	@RepeatedTest(10)
	public void findAll() {
		final Collection<UsuarioComercial> all = this.service.findAll();

		assertNotNull(all);
		assertFalse(all.isEmpty());
	}

	@RepeatedTest(1)
	public void findById() {
		final UsuarioComercialPK id = new UsuarioComercialPK("fec216ab-973f-45e0-b1fd-8fbb0a1c6a10");
		final UsuarioComercial found = this.service.findById(id);

		assertNotNull(found);
		assertEquals(id, found.getPk());
	}

	@RepeatedTest(1)
	public void getTree() {
		final Collection<TreeNode<UsuarioComercial>> trees = this.service.getRoots().stream().map(this.service::getTree)
				.collect(Collectors.toList());

		System.out.println("Tree:");
		print(trees);
		assertNotNull(trees);
		assertFalse(trees.isEmpty());
	}

	
	@RepeatedTest(1)
	public void getDescendants() {
		final UsuarioComercial ancestral = (UsuarioComercial) this.service.findAll().toArray()[0];
		final Collection<UsuarioComercial> descendants = this.service.getDescendants(ancestral);
		System.out.println("List:");
		descendants.forEach(u->System.out.println(u.getNome() + " ("+u.getPk().getId()+") "));
		assertTrue(descendants.stream().allMatch(element -> this.service.isDescendant(element, ancestral)));
	}
//
//    @RepeatedTest(1)
//    void getAncestors() {
//        final UsuarioComercial element = this.organizationUnitGenerator.getRandomElement(this.service.findAll());
//        final Collection<UsuarioComercial> ancestors = this.service.getAncestors(element);
//		System.out.println("List:");
//		ancestors.forEach(u->System.out.println(u.getId()+" - "+u.getNome()));
//        assertTrue(ancestors.stream().allMatch(ancestor -> this.service.isAncestral(ancestor, element)));
//    }
//
//
//

//    @RepeatedTest(10)
//    public void getRoots() {
//        final Collection<UsuarioComercial> roots = this.service.getRoots();
//
//        assertNotNull(roots);
//        assertFalse(roots.isEmpty());
//        assertTrue(roots.stream()
//                .map(IElement::getParentId)
//                .allMatch(Objects::isNull));
//    }
//
//    @RepeatedTest(10)
//    public void isRoot() {
//        final UsuarioComercial element = Mockito.mock(UsuarioComercial.class);
//
//        when(element.getParentId()).thenReturn(null);
//        assertTrue(this.service.isRoot(element));
//
//        when(element.getParentId()).thenReturn(1L);
//        assertFalse(this.service.isRoot(element));
//    }
	
	/**
	 * @param trees
	 */
	private void print(final Collection<TreeNode<UsuarioComercial>> trees) {
		trees.forEach(u -> {
			System.out.println("|- [" + u.getElement().getNome() + "]");

			if (u.getChildren() != null)
				u.getChildren().forEach(u2 -> {
					System.out.println("|---- [" + u2.getElement().getNome() + "]");

					if (u2.getChildren() != null)
						u2.getChildren().forEach(u3 -> {
							System.out.println("|------- [" + u3.getElement().getNome() + "]");

							if (u3.getChildren() != null)
								u3.getChildren().forEach(u4 -> {
									System.out.println("|---------- [" + u4.getElement().getNome() + "]");
								});
						});

				});
		});
	}

}
