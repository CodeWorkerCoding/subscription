package com.nchu.weixin.subscription.repo.rim;

import com.nchu.weixin.subscription.rim.domain.SecretConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * REPO
 * Created by fujianjian on 2017/2/20.
 */
public interface SecretConfigRepo extends JpaRepository<SecretConfig, String> {
}
