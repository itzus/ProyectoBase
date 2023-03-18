
package com.asw.test.app.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asw.test.app.base.entities.BancoEntity;

@Repository
public interface BancoRepository extends JpaRepository<BancoEntity, Integer> {
}

