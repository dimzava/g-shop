package eu.salonexperts

import org.springframework.transaction.annotation.Transactional;

@Transactional
class BaseService {

    def save(instance) {
		if(instance.save()) {
			return instance
		}
		else {
			throw new ServiceException(message: "action.save.fail", instance: instance)
		}
	}
	
	def update(instance) {
		if(instance.save()) {
			return instance
		}
		else {
			throw new ServiceException(message: "action.update.fail", instance: instance)
		}
	}
	
	def delete(instance) {
		try {
			instance.delete(flush: true)
		}
		catch(e) {
			throw new ServiceException(message: "action.delete.fail", instance: instance)
		}
	}
}

class ServiceException extends RuntimeException {
	String message
	def instance
}
