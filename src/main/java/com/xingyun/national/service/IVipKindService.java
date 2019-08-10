package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.VipKind;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-17
 */
@Component
public interface IVipKindService extends IService<VipKind> {
    public PageInfo<VipKind> findVipKind(int page, int limit);

    public VipKind getAllById(long id);

    public List<VipKind> findAll();
}
