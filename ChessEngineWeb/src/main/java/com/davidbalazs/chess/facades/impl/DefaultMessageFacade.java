package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.converters.MessageConverter;
import com.davidbalazs.chess.data.ContactUsForm;
import com.davidbalazs.chess.facades.MessageFacade;
import com.davidbalazs.chess.models.MessageModel;
import com.davidbalazs.chess.services.MessageService;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by David B on 4/26/2016.
 */
public class DefaultMessageFacade implements MessageFacade {
    private MessageService messageService;
    private MessageConverter messageConverter;

    public void create(ContactUsForm contactUsForm) {
        MessageModel messageModel = messageConverter.convert(contactUsForm);
        messageService.create(messageModel);
    }

    @Required
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Required
    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }
}
