package com.spring_docker_compose_example.enums;

public enum State {
    ADDED {
        @Override
        public State nextState() {
            return IN_CHECK;
        }
    },

    IN_CHECK {
        @Override
        public State nextState() {
            return APPROVED;
        }
    },

    APPROVED {
        @Override
        public State nextState() {
            return ACTIVE;
        }
    },

    ACTIVE {
        @Override
        public State nextState() {
            return this;
        }
    };

    public abstract State nextState();
}
