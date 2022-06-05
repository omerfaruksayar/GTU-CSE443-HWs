public interface Command {

    /**
     * Wrapper for the main action
     * @param index is integer, needed for the get action.
     * @return Object
     */
    Object execute(int index);

    /**
     * Wrapper for the main actions
     * @param o is Object which will be added or removed
     */
    void execute(Object o);
}
