package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.exceptions.TipoDocumentoException;
import co.edu.umb.academia.siajardin.model.TipoDocumento;
import co.edu.umb.academia.siajardin.repo.TipoDocumentoJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<TipoDocumento> listarTipoDocumento() throws TipoDocumentoException {
        return repo.findAll();
    }

}
