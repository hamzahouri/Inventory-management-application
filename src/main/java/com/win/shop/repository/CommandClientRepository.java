package com.win.shop.repository;

import com.win.shop.model.CommandClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandClientRepository extends JpaRepository<CommandClient,Long> {

    Optional<CommandClient> findCommandClientByCode(String code);
}
