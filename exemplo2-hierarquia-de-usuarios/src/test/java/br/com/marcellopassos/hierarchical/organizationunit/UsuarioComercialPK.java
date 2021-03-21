package br.com.marcellopassos.hierarchical.organizationunit;

import java.io.Serializable;
import java.util.UUID;

public class UsuarioComercialPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private UUID tenant;

	public UsuarioComercialPK(String id) {
		this.id = UUID.fromString(id);
		this.tenant = UUID.fromString("b2a79e76-efdb-4b71-9dc9-542909676131");
		//this.tenant = TenantService.getTenantId();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getTenant() {
		return tenant;
	}

	public void setTenant(UUID tenant) {
		this.tenant = tenant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioComercialPK other = (UsuarioComercialPK) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}
}
