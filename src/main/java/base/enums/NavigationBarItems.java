package base.enums;

   public enum NavigationBarItems {
        HOME ("HOME"),
        CONTACT_FORM ("CONTACT FORM"),
        SERVICE ("SERVICE"),
        METALS_COLORS ("METALS & COLORS");

        private static final int size = NavigationBarItems.values().length;

        private final String item;

       NavigationBarItems(String item) {
            this.item = item;
        }

        public static int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return item;
        }
    }
