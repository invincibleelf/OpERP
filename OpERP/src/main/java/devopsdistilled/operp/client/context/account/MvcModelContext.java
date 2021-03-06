package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.panes.models.PaidTransactionPaneModel;
import devopsdistilled.operp.client.account.panes.models.ReceivedTransactionPaneModel;
import devopsdistilled.operp.client.account.panes.models.impl.PaidTransactionPaneModelImpl;
import devopsdistilled.operp.client.account.panes.models.impl.ReceivedTransactionPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public ReceivedTransactionPaneModel receivedTransactionPaneModel() {
		return new ReceivedTransactionPaneModelImpl();
	}
	
	@Bean
	public PaidTransactionPaneModel paidTransactionPaneModel() {
		return new PaidTransactionPaneModelImpl();
	}

}
