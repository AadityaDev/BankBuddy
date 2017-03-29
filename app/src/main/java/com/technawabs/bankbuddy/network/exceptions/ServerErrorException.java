package com.technawabs.bankbuddy.network.exceptions;

import com.aditya.edforaapp.constants.AppConstant;

public class ServerErrorException extends HttpException {

    public ServerErrorException() {
        super(AppConstant.MESSAGE_SERVER_ERROR);
    }
}
