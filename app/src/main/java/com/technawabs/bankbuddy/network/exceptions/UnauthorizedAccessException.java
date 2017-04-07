package com.technawabs.bankbuddy.network.exceptions;

import com.technawabs.bankbuddy.constants.AppConstant;

public class UnauthorizedAccessException extends HttpException {

    public UnauthorizedAccessException() {
        super(AppConstant.EXCEPTION.UNAUTHORIZED_ACCESS);
    }
}
