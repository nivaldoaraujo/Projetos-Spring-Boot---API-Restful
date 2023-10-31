package com.aula.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.aula.msemail.entities.EmailModel;
import com.aula.msemail.enums.StatusEmail;
import com.aula.msemail.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;

	@Autowired
	private JavaMailSender emailSender;

	@Transactional
	public EmailModel enviarEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getTituloEmail());
			message.setText(emailModel.getCorpoEmail());
			emailSender.send(message);

			emailModel.setStatusEmail(StatusEmail.ENVIADO);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERRO);
		} finally {
			return repository.save(emailModel);
		}
	}
}
