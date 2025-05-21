class EventEmitter {
    constructor() {
        this.events = {};
        this.subscriptionId = 0;
        this.subscriptionMap = new Map(); // Map id -> { eventName, callback }
    }

    /**
     * Subscribes to an event.
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object} An object with an `unsubscribe` method
     */
    subscribe(eventName, callback) {
        if (!this.events[eventName]) {
            this.events[eventName] = [];
        }

        const id = this.subscriptionId++;
        const subscription = { id, callback };
        this.events[eventName].push(subscription);
        this.subscriptionMap.set(id, { eventName, callback });

        return {
            unsubscribe: () => {
                const subs = this.events[eventName];
                if (!subs) return;
                this.events[eventName] = subs.filter(sub => sub.id !== id);
                this.subscriptionMap.delete(id);
            }
        };
    }

    /**
     * Emits an event and calls all subscribed callbacks.
     * @param {string} eventName
     * @param {Array} args
     * @return {Array} The results of all callbacks
     */
    emit(eventName, args = []) {
        const subs = this.events[eventName] || [];
        return subs.map(sub => sub.callback(...args));
    }
}
