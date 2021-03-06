package devopsdistilled.operp.server.data.service.account.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.account.Transaction;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

public abstract class TransactionServiceImpl<T extends Transaction<?>, TR extends JpaRepository<T, Long>>
		extends AbstractEntityService<T, Long, TR> {

	private static final long serialVersionUID = -4898201898165854461L;

	@Override
	protected T findByEntityName(String entityName) {
		return null;
	}

}
