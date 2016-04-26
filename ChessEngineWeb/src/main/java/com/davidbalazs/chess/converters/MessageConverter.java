package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.ContactUsForm;
import com.davidbalazs.chess.models.MessageModel;

import java.util.Date;

/**
 * Created by David B on 4/26/2016.
 */
public class MessageConverter {

    public MessageModel convert(ContactUsForm contactUsForm) {
        MessageModel messageModel = new MessageModel();
        messageModel.setEmail(contactUsForm.getEmail());
        messageModel.setUsername(contactUsForm.getUsername());
        messageModel.setText(contactUsForm.getMessage());
        messageModel.setDate(new Date());
        messageModel.setRead(false);
        return messageModel;
    }
}
