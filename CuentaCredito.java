package CuentaCredito;

public class CuentaCredito extends Cuenta {

//	Constantes

	private final static int CREDITO_DEF = 100;
	private final static int CREDITO_MAXIMO = 300;

//	Atributos

	private static int credito;

//	Constructor

	public CuentaCredito(double saldo, String titular, int credito) throws CuentaException, cuentaCreditoException {

		super(saldo, titular);
		comprobarCredito(credito);

	}

	public CuentaCredito(String titular) {

		super(titular);

	}

	public CuentaCredito(String titular, double saldo) throws CuentaException {

		super(saldo, titular);
		this.credito = CREDITO_DEF;

	}

	public CuentaCredito(String titular, int credito) throws CuentaException, cuentaCreditoException {

		super(titular);
		comprobarCredito(credito);
		saldo = 0;

	}

//	Metodos

	public void realizarReintegro(double cantidad) throws CuentaException {

//		Variables
		double operacion;

		if (cantidad > saldo) {

			operacion = cantidad - saldo;
			credito -= operacion;

		}

		super.realizarReintegro(cantidad);

		if (cantidad > saldo) {
			saldo = 0;
		}

	}

	public void comprobarCredito(int credito) throws cuentaCreditoException {

		if (credito > CREDITO_MAXIMO) {

			throw new cuentaCreditoException("El credito no puede superar los 300 euros");

		} else if (credito < 0) {

			throw new cuentaCreditoException("El credito no puede ser inferior a 0 euros");

		}

		this.credito = credito;

	}

//	GET y SET

	public static int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

}
