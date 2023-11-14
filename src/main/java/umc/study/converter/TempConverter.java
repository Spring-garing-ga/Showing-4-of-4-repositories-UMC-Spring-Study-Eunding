package umc.study.converter;

import umc.study.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is TEST")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
<<<<<<< HEAD
=======
<<<<<<< HEAD
bran
=======
>>>>>>> b491067d951fd4810a0a3297e4bdb405178d39a3
>>>>>>> erd/merge
