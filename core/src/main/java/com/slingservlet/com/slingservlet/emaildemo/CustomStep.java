package com.slingservlet.com.slingservlet.emaildemo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;



@Service
@Properties({
	@Property(name=Constants.SERVICE_DESCRIPTION,value="Test email workflow"),
	@Property(name=Constants.SERVICE_VENDOR,value="Adobe"),
	@Property(name="process.label",value="Test stage email NOTIC workflow process")
})
public class CustomStep implements WorkflowProcess{
	
	@Reference
	private MessageGatewayService messageGatewayService;
	
	
	
	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		try{
			MessageGateway<Email> messageGateway;
			
			Email email = new SimpleEmail();
			String emailToRecipients ="xqcaoumail@gmail.com";
			String emailCcRecipients ="xqcaomail@gmail.com";
			email.addTo(emailToRecipients);
			email.addCc(emailCcRecipients);
			email.setSubject("AEM Custom Step");
			email.setFrom("xqcaoumail@gmail.com");
			email.setMsg("this is emial notic when start custom workflow from AEM");
			
			messageGateway = messageGatewayService.getGateway(Email.class);
			messageGateway.send(email);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
