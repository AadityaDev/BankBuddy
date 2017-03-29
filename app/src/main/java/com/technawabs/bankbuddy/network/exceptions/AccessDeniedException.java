package com.technawabs.bankbuddy.network.exceptions;

import com.aditya.edforaapp.constants.AppConstant;

public class AccessDeniedException extends HttpException {
    public AccessDeniedException() {
        super(AppConstant.EXCEPTION.ACCESS_DENIED);
    }
}
