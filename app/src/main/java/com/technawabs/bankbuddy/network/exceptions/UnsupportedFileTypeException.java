package com.technawabs.bankbuddy.network.exceptions;

import com.technawabs.bankbuddy.constants.AppConstant;

public class UnsupportedFileTypeException extends HttpException {

    public UnsupportedFileTypeException() {
        super(AppConstant.EXCEPTION.MESSAGE_UNSUPPORTED_FILE_TYPE);
    }

}
