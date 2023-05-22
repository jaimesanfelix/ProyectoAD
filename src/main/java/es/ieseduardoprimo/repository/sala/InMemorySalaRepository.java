package es.ieseduardoprimo.repository.sala;

import java.io.IOException;
import java.util.List;

import es.ieseduardoprimo.model.Sala;
import lombok.NonNull;

public class InMemorySalaRepository implements SalaRepository{
    
    /* @NonNull
    private SalasRest salaService;

    @NonNull
    private SalaMapper salaMapper; 

    @Override
    public List<Sala> findAll() {
        List<Sala> result = null;
        try {
            Response<List<SalaDTO>> response = salaService.salasGetAll().execute();

            if (response.isSuccessful() && response.body() != null) {
                result = salaMapper.fromDTO(response.body());
            }
        } catch (IOException e) {
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        return result;

    }

    @Override
    public Sala findById(Integer id) {
        Sala result = null;
        try {
            Response<SalaDTO> response = salaService.salaGetById(id.intValue()).execute();
            result = salaMapper.fromDTO(response.body());
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'findById'");
        }

        return result;

    }

    @Override
    public boolean create(Sala entity) {
        boolean created = false;
        
        try {
            Response<ResponseDTO> response = salaService.partidaCreate(salaMapper.toDTO(entity)).execute();
            if (response.body().getCreated() == 1) {
                created = true;
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'create'");
        }

        return created;

    }

    @Override
    public boolean update(Sala entity) {
        boolean updated = false;
        
        try {
            Response<ResponseDTO> response = salaService.partidaUpdate(entity.getId(), salaMapper.toDTO(entity)).execute();
            if (response.body().getUpdated() == 1) {
                updated = true;
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'updated'");
        }

        return updated;

    }

    @Override
    public boolean delete(Integer id) {
        boolean deleted = false;
        
        try {
            Call<ResponseDTO> response = salaService.partidaDelete(id);
            if (response.isExecuted()) {
                deleted = true;
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

        return deleted;

    }

    @Override
    public boolean create(Sala entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean update(Sala entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
*/
}
