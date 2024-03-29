
package acme.features.anonymous.ruizbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ruizbulletins.RuizBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousRuizBulletinCreateService implements AbstractCreateService<Anonymous, RuizBulletin> {

	@Autowired
	AnonymousRuizBulletinRepository repository;


	@Override
	public void bind(final Request<RuizBulletin> request, final RuizBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public RuizBulletin instantiate(final Request<RuizBulletin> request) {
		assert request != null;

		RuizBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new RuizBulletin();
		result.setJob("Informatico");
		result.setCompany("ACME");
		result.setMoment(moment);
		return result;
	}

	@Override
	public void validate(final Request<RuizBulletin> request, final RuizBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<RuizBulletin> request, final RuizBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

	@Override
	public boolean authorise(final Request<RuizBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<RuizBulletin> request, final RuizBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "job", "company");

	}

}
