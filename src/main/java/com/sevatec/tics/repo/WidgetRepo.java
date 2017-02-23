package com.sevatec.tics.repo;

import org.springframework.data.repository.CrudRepository;

import com.sevatec.tics.domain.Widget;

public interface WidgetRepo extends CrudRepository<Widget, Long>{
}
