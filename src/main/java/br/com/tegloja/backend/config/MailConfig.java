package br.com.tegloja.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSenderl;
	
	public void enviarEmail(String para, String assunto, String texto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("hitalo.silva@aluno.senai.br");
		simpleMailMessage.setTo(para);
		simpleMailMessage.setSubject(assunto);
		simpleMailMessage.setText("Dados da Compra"+texto+ "\n\n\n Serratec - TEGLOJA - 2022");
		javaMailSenderl.send(simpleMailMessage);
	}
	
	public void enviarEmail(String para, String assunto, String texto,String texto1) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("hitalo.silva@aluno.senai.br");
		simpleMailMessage.setTo(para);
		simpleMailMessage.setSubject(assunto);
		simpleMailMessage.setText("Dados da Compra"+texto+ "\n\n\n Serratec - TEGLOJA - 2022");
		javaMailSenderl.send(simpleMailMessage);
	}
}


