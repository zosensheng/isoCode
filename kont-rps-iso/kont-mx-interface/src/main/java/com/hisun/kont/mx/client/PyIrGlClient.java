package com.hisun.kont.mx.client;



import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(
        name = "kont-pymx-app",
        url = "${fegin.pyUrl}"
)
public interface PyIrGlClient {

    @PostMapping("/py/irPacs00800110")
    @ApiOperation(value = "rps联机出账接口", notes = "rps联机出账接口")
    GenericRspDTO<NoBody> irPacs00800110(@Validated @RequestBody GenericDTO<MXPacs00800110> reqDto) ;
}
