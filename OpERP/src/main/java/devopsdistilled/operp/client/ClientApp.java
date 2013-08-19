package devopsdistilled.operp.client;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.client.context.AppContext;
import devopsdistilled.operp.client.main.MainWindow;

public class ClientApp {

	public static void main(String[] args) {

		// Apply Nimbus LAF
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.err
					.println("Nimbus Look and Feel not available.\nReverting to default");
		}

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);

		MainWindow window = context.getBean(MainWindow.class);
		window.init();

		System.out.println(context);
	}
}
