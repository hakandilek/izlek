package me.dilek.cezmi.domain;

public class TvShowNotFoundException extends Exception {

    private static final long serialVersionUID = -3701637532600810961L;

    public TvShowNotFoundException() {
        super();
    }

    public TvShowNotFoundException(final String message) {
        super(message);
    }

    public TvShowNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TvShowNotFoundException(final Throwable cause) {
        super(cause);
    }
}
