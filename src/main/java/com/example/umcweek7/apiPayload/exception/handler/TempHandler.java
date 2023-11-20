package com.example.umcweek7.apiPayload.exception.handler;

import com.example.umcweek7.apiPayload.code.BaseErrorCode;
import com.example.umcweek7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}