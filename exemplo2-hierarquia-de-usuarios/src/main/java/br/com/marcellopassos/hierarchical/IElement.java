package br.com.marcellopassos.hierarchical;

public interface IElement<R> {

    R getPk();

    R getParentPk();

    default boolean checkId(R id) {
        return this.getPk().equals(id);
    }
}
