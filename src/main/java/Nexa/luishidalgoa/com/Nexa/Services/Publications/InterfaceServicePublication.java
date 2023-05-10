package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;

import java.util.List;

public interface InterfaceServicePublication {
    public List<Publication> findAll();
    public void Save(Publication publication);
    public void DeletePublication(int id);
}
