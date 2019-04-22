package ru.spaceouter.infoscan.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author danil
 * @date 22.04.19
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestoreDTO {

    private String uuid;
    private String password;

}
