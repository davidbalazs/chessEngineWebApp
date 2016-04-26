package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.ContactUsForm;
import com.davidbalazs.chess.models.MessageModel;

import java.util.List;

/**
 * Created by David B on 4/26/2016.
 */
public interface MessageFacade {

    void create(ContactUsForm message);
}
