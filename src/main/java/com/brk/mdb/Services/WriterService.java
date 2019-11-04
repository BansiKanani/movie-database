package com.brk.mdb.Services;

import java.util.List;

import com.brk.mdb.models.Movie;
import com.brk.mdb.models.Writer;

public interface WriterService {

	Writer insertOne(String name);

	List<Writer> getByName(String name);

	List<Writer> getAll();

	List<Movie> getWrittenBy(Writer writer);

}
