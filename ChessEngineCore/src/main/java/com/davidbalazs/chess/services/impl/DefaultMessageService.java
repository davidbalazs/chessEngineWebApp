package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.MessageDao;
import com.davidbalazs.chess.models.MessageModel;
import com.davidbalazs.chess.services.MessageService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Created by David B on 4/26/2016.
 */
public class DefaultMessageService implements MessageService {
    private MessageDao messageDao;

    @Override
    public List<MessageModel> getAll() {
        return messageDao.getAll();
    }

    @Override
    public MessageModel getById(long id) {
        return messageDao.getById(id);
    }

    @Override
    public void create(MessageModel message) {
        messageDao.create(message);
    }

    @Required
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
