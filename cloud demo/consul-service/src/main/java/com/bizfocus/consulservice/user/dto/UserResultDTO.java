package com.bizfocus.consulservice.user.dto;

import lombok.Data;
import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-04 16:11
 **/
@Data
public class UserResultDTO extends PageInfoDTO {
    private List<UserDTO> userDTOList;
}
