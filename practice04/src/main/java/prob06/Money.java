package prob06;

import java.util.Objects;

public class Money {
	
	private int amount;
	
	public Money(int amount) {
		setAmount(amount);
	}

	private void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	public boolean equals(Money obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

	public int getAmount() {
		return amount;
	}

	public Money add(Money money) {
		return new Money(this.amount+money.getAmount());
	}

	public Money minus(Money money) {
		return new Money(this.amount-money.getAmount());
	}

	public Money multiply(Money money) {
		return new Money(this.amount*money.getAmount());
	}

	public Money divide(Money money) {
		return new Money(this.amount/money.getAmount());
	}

	



	
	/* 코드 작성 */
}
