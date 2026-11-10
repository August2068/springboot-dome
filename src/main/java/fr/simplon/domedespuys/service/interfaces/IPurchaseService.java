package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Purchase;

public interface IPurchaseService extends
        IGetItem<Purchase>,
        ICollection<Purchase>,
        ICreate<Purchase, PurchasePostDTO>,
        IUpdate<Purchase, PurchasePutDTO>
{
}
